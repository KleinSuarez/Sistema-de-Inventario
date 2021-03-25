import { ListProductsComponent } from './componentes/list-products/list-products.component';
import { HomeComponent } from './componentes/home/home.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {path: '*', component: HomeComponent},
  {path: 'home', component: HomeComponent},
  {path: 'list', component: ListProductsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
