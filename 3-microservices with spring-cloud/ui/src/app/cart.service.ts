import { Injectable } from '@angular/core';

import { Subject } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  cart = {}
  cartQty = 0;

  cartStream = new Subject()

  constructor(private http: HttpClient) { }

  getCartQty() {
    return this.cartQty;
  }
  getCartStream() {
    return this.cartStream;
  }
  getCart() {
    return this.cart;
  }

  addToCart(event, qty = 1) {
    let { item } = event;
    let id;
    if (item._links.self) {
      id = item._links.self.href.substring(item._links.self.href.lastIndexOf('/') + 1)
    }
    item.id = id;
    let cartLine = this.cart[id] // cartLine={item,qty}
    if (cartLine) {
      cartLine = { ...cartLine, qty: cartLine.qty + qty }
    } else {
      cartLine = { item, qty: 1 }
    }
    if (cartLine.qty === 0) {
      delete this.cart[id]
    } else {
      this.cart = { ...this.cart, [id]: cartLine }
    }
    this.http.post("http://localhost:8083/cart/Nag", cartLine)
      .subscribe(response => {
        this.cartQty = Object.keys(this.cart).length
        this.cartStream.next({ cart: this.cart, cartQty: this.cartQty })
      })
  }

  checkout() {
    this.http.post("http://localhost:8084/checkout/Nag", {})
      .subscribe(response => {
        this.cart = {};
        this.cartQty = Object.keys(this.cart).length
        this.cartStream.next({ cart: this.cart, cartQty: this.cartQty })
      })
  }

  loadCart() {
    this.http.get("http://localhost:8083/cart/Nag")
      .subscribe((response: Array<any>) => {
        response.forEach(line => {
          this.cart[line.item.id] = line
        })
        this.cartQty = Object.keys(this.cart).length
        this.cartStream.next({ cart: this.cart, cartQty: this.cartQty })
      })
  }

  loadOrders() {
    return this.http.get("http://localhost:8084/orders")
  }

}
