import {Component, OnDestroy, OnInit} from '@angular/core';
import {FormBuilder, FormControl} from "@angular/forms";
import {CityService} from "../city.service";
import {Subject, Subscription} from "rxjs";
import {Page} from "../page.model";
import {Router} from "@angular/router";

@Component({
  selector: 'app-city-list',
  templateUrl: './city-list.component.html',
  styleUrls: ['./city-list.component.css']
})
export class CityListComponent implements OnInit, OnDestroy {

  constructor(private cityService: CityService,
              private router: Router
              ) {
  }


  ngOnInit(): void {
    this.cityService.getPage().subscribe(obs => {
      if (obs.ok) {
        this.currentPage = obs.body
      }
    });
  }

  ngOnDestroy() {
  }

  public searchControl = new FormControl('');
  public currentPage: Page<City> | null = null;
  private pageNumber = 0;

  public submit(): void {
    this.cityService.getPage(this.pageNumber, 10, this.searchControl.value!).subscribe(obs => {
      if (obs.ok) {
        this.currentPage = obs.body;
        this.pageNumber = this.currentPage?.number!;
      }
    });
  }

  public first(): void {
    this.pageNumber = 0
    this.submit();
  }

  public prev(): void {
    this.pageNumber--;
    this.submit()
  }

  public next(): void {
    this.pageNumber++;
    this.submit();
  }

  public last(): void {
    this.pageNumber = this.currentPage?.totalPages! - 1;
    this.submit();
  }

  navigate(id: number) {
    console.log('id', id);
    this.router.navigateByUrl(`/cities/` + id);
  }
}
