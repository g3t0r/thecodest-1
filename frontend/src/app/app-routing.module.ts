import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {CityListComponent} from "./city-list/city-list.component";
import {CityEditComponent} from "./city-edit/city-edit.component";

const routes: Routes = [
  {
    path: 'cities',
    component: CityListComponent,
  },
  {
    path: '',
    redirectTo: 'cities',
    pathMatch: 'full'
  },
  {
    path: 'cities/:id',
    component: CityEditComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
