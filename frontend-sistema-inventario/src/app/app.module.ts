import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MenuComponent } from './componentes/menu/menu.component';
import { HomeComponent } from './componentes/home/home.component';
import { ListProductsComponent } from './componentes/list-products/list-products.component';
import { FormAddProductComponent } from './componentes/form-add-product/form-add-product.component';
import { FormEditProductComponent } from './componentes/form-edit-product/form-edit-product.component';
import { BreadcrumbComponent } from './componentes/breadcrumb/breadcrumb.component';

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    HomeComponent,
    ListProductsComponent,
    FormAddProductComponent,
    FormEditProductComponent,
    BreadcrumbComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
