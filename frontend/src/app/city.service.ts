import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Page} from "./page.model";

@Injectable({
  providedIn: 'root'
})
export class CityService {

  constructor(private http: HttpClient) {
  }

  public getPage(page = 0, size = 10, search?: string | undefined) {
    let params = new HttpParams()
    .set("page", page)
    .set("size", size);
    if (search !== undefined) {
      params = params.set("search", search);
    }
    console.log('params', params);
    return this.http.get<Page<City>>('cities', {
      params,
      observe: "response"
    });
  }


}
