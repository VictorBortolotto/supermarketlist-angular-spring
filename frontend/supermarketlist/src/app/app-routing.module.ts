import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/pages/home/home.component';
import { LoginPageComponent } from './components/pages/login-page/login-page.component';
import { ProductsPageComponent } from './components/pages/products-page/products-page.component';
import { RegistryPageComponent } from './components/pages/registry-page/registry-page.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginPageComponent },
  { path: 'registry', component: RegistryPageComponent},
  { path: 'products', component: ProductsPageComponent }
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents = [HomeComponent, LoginPageComponent, RegistryPageComponent, ProductsPageComponent]
