import { ListProductTypeComponent } from './components/list-product-type/list-product-type.component';
import { AddProductComponent } from './components/add-product/add-product.component';
import { ProductFormComponent } from './components/product-form/product-form.component';
import { HomeComponent } from './components/home/home.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListComponent } from './components/list/list.component';
import { UpdateProductComponent } from './components/update-product/update-product.component';
import { TransactionHistoryComponent } from './components/transaction-history/transaction-history.component';
import { LoginComponent } from './components/login/login.component';

const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'home', component: HomeComponent},
  { path: 'list-products', component: ListComponent},
  { path: 'update-product/:idProduct', component: UpdateProductComponent},
  { path: 'add-product', component: AddProductComponent},
  { path: 'list-product-type', component: ListProductTypeComponent},
  { path: 'transaction-history', component: TransactionHistoryComponent},
  {path:'login', component: LoginComponent}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
