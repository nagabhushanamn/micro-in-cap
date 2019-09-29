import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { ItemService } from '../item.service';
import { CartService } from '../cart.service';

@Component({
  selector: 'app-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.css']
})
export class ItemComponent implements OnInit {

  @Input('value') item;  // props
  itemQty = 0;
  currentTab = 1 // state
  @Output() buy = new EventEmitter(); // event
  itemId;

  reviews = []

  constructor(
    private itemService: ItemService,
    private cartService: CartService
  ) { }
  ngOnInit() {
  }
  ngDoCheck() {
    if (this.item._links.self) {
      this.itemId = this.item._links.self.href.substring(this.item._links.self.href.lastIndexOf('/') + 1)
      let cartLine = this.cartService.getCart()[this.itemId] || {};
      this.itemQty = cartLine.qty
    }
  }
  changeTab(event, tabIndex) {
    event.preventDefault();
    this.currentTab = tabIndex
    if (this.currentTab === 3) {
      this.itemService.loadReviews(this.itemId)
        .subscribe((response: any) => {
          this.reviews = response._embedded.reviews
        })
    }
  }
  isTabSelected(tabIndex) {
    return this.currentTab === tabIndex;
  }
  handleBuy(event) {
    this.cartService.addToCart({ item: this.item })
  }
  handleNewReview(review) {
    this.itemService.submitNewReview(this.itemId, review)
      .subscribe(review => {
        this.reviews = this.reviews.concat(review);
      })
  }

}
