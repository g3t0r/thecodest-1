import {Component, OnDestroy, OnInit} from '@angular/core';
import {FormBuilder, FormControl} from "@angular/forms";
import {CityService} from "../city.service";
import {Subject, Subscription} from "rxjs";
import {Page} from "../page.model";

@Component({
  selector: 'app-city-list',
  templateUrl: './city-list.component.html',
  styleUrls: ['./city-list.component.css']
})
export class CityListComponent implements OnInit, OnDestroy {

  constructor(private cityService: CityService) { }



  ngOnInit(): void {
      this.cityService.getPage().subscribe(obs => {
        if(obs.ok) {
          this.currentPage = obs.body
        }
      });
  }

  ngOnDestroy() {
  }

  public searchControl = new FormControl('');
  public currentPage: Page<City> | any = null;
  private subs: Subscription = new Subscription();

  public submit(): void {
    this.cityService.getPage(0, 10, this.searchControl.value!!).subscribe(obs => {
      if(obs.ok) {
        this.currentPage = obs.body
      }
    });
  }

}
