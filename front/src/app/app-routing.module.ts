import { ClienteReadComponent } from './views/components/cliente/cliente-read/cliente-read.component';
import { ProdutoReadComponent } from './views/components/produto/produto-read/produto-read.component';
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
import { PetReadComponent } from './views/components/pet/pet-read/pet-read.component';
import { ServicoReadComponent } from './views/components/servico/servico-read/servico-read.component';
import { PedidoReadComponent } from './views/components/pedido/pedido-read/pedido-read.component';
import { PetCreateComponent } from './views/components/pet/pet-create/pet-create.component';

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
      path: 'cliente/read',
      component: ClienteReadComponent
    },
    {
      path: 'produto/read',
      component: ProdutoReadComponent
    },
    {
      path: 'pet/read',
      component: PetReadComponent
    },
    {
      path: 'servico/read',
      component: ServicoReadComponent
    },
    {
      path: 'pedido/read',
      component: PedidoReadComponent
    },
    {
      path: 'funcionario/cadastro',
      component: FuncionarioCreateComponent
    },
    {
      path: 'pet/cadastro',
      component: PetCreateComponent
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
