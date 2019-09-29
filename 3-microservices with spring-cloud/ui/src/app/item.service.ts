import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ItemService {

  constructor(private httpClient: HttpClient) { }

  loadItems() {
    let apiURL = "http://localhost:8080/catalog/items";
    return this.httpClient.get(apiURL)
  }
  loadReviews(itemId) {
    let apiURL = `http://localhost:8080/review/reviews/search/findByItemId?itemId=${itemId}`;
    return this.httpClient.get(apiURL)
  }
  submitNewReview(itemId, review) {
    review.itemId=itemId;
    let apiURL = `http://localhost:8080/review/reviews`;
    return this.httpClient.post(apiURL, review)
  }

}
