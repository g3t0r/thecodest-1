import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {tap} from "rxjs";
import {CityService} from "../city.service";
import {FormControl} from "@angular/forms";

@Component({
  selector: 'app-city-edit',
  templateUrl: './city-edit.component.html',
  styleUrls: ['./city-edit.component.css']
})
export class CityEditComponent implements OnInit {

  constructor(private route: ActivatedRoute,
              private cityService: CityService,
              private router: Router
              ) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      const selectedId =  params.get("id") as unknown as number;
      this.cityService.getById(selectedId).subscribe(resp => {
        if(resp.ok) {
          this.city = resp.body;
          this.nameFC.setValue(this.city?.name!)
          this.photoFC.setValue(this.city?.photo!)
        }
      })
    })
  }

  public city: City | null = null;
  public nameFC = new FormControl("")
  public photoFC = new FormControl("")

  public save() {
    this.cityService.update(this.city?.id!, {
     name: this.nameFC.value!,
      photo: this.photoFC.value!
    }).subscribe(
      () => this.router.navigateByUrl("cities")
    );
  }

}
