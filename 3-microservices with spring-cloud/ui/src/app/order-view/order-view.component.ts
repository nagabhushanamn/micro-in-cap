import { Component, OnInit } from '@angular/core';
import { CartService } from '../cart.service';

@Component({
  selector: 'app-order-view',
  templateUrl: './order-view.component.html',
  styleUrls: ['./order-view.component.css']
})
export class OrderViewComponent implements OnInit {

  orders = [];

  constructor(private cartService: CartService) { }

  ngOnInit() {
    this.cartService.loadOrders()
      .subscribe((response: any) => {
        this.orders = response
      })
  }

}
