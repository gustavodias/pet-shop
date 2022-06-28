import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClienteCreateComponent } from './views/components/cliente/cliente-create/cliente-create.component';
import { LoginComponent } from './views/components/login/login.component';
import { FuncionarioCreateComponent } from './views/components/funcionario/funcionario-create/funcionario-create.component';
import { HomeComponent } from './views/components/home/home.component';
import { FuncionarioReadComponent } from './views/components/funcionario/funcionario-read/funcionario-read.component';
import { FuncionarioUpdateComponent } from './views/components/funcionario/funcionario-update/funcionario-update.component';
import { CargoCreateComponent } from './views/components/funcionario/cargo/cargo-create/cargo-create.component';
import { CargoUpdateComponent } from './views/components/funcionario/cargo/cargo-update/cargo-update.component';

const routes: Routes = [
  {
    path:'',
    component: HomeComponent
  },
  {
    path: 'cliente/cadastro',
    component: ClienteCreateComponent
    },
    {
      path: 'login',
      component: LoginComponent
    },
    {
      path: 'funcionario/read',
      component: FuncionarioReadComponent
    },
    {
      path: 'funcionario/cadastro',
      component: FuncionarioCreateComponent
    },
    {
      path: 'funcionario/update/:id',
      component: FuncionarioUpdateComponent
    },
    {
      path: 'cargo/cadastro',
      component: CargoCreateComponent
    },
    {
      path: 'cargo/update/:id',
      component: CargoUpdateComponent
    }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
