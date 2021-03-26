import { ListProductsComponent } from './componentes/list-products/list-products.component';
import { HomeComponent } from './componentes/home/home.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FormAddProductComponent } from './componentes/form-add-product/form-add-product.component';
import { FormEditProductComponent } from './componentes/form-edit-product/form-edit-product.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'home', component: HomeComponent },
  { path: 'list', component: ListProductsComponent },
  { path: 'add-product', component: FormAddProductComponent },
  { path: 'edit-product', component: FormEditProductComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
