import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Page} from "./page.model";
import {UpdateCityModelRequest} from "./update-city-model.request";
import * as http from "http";

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

  public getById(id: number) {
    return this.http.get<City>(`cities/${id}`, {observe: "response"});
  }

  public update(id: number, update: UpdateCityModelRequest) {
    return this.http.put(`cities/${id}`, update, {observe: "response"})
  }

}
