import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ItemService {

  constructor(private httpClient: HttpClient) { }

  loadItems() {
    let apiURL = "http://167.71.236.13:8081/items";
    return this.httpClient.get(apiURL)
  }
  loadReviews(itemId) {
    let apiURL = `http://localhost:8082/reviews/search/findByItemId?itemId=${itemId}`;
    return this.httpClient.get(apiURL)
  }
  submitNewReview(itemId, review) {
    review.itemId=itemId;
    let apiURL = `http://localhost:8082/reviews`;
    return this.httpClient.post(apiURL, review)
  }

}
