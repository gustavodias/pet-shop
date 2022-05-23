import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClienteCreateComponent } from './views/components/cliente/cliente-create/cliente-create.component';
import { LoginComponent } from './views/components/login/login.component';

const routes: Routes = [
  {
    path: 'cliente/cadastro',
    component: ClienteCreateComponent
    },
    {
      path: 'login',
      component: LoginComponent
    }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
