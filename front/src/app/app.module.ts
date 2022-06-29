import { DEFAULT_CURRENCY_CODE, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { MatSelectModule } from '@angular/material/select';
import { MatInputModule } from '@angular/material/input';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatListModule } from '@angular/material/list';
import { MatCardModule } from '@angular/material/card';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatMenuModule } from '@angular/material/menu';


import { FooterComponent } from './views/components/template/nav/footer/footer.component';
import { NavComponent } from './views/components/template/nav/nav/nav.component';

import { NgxMaskModule, IConfig } from 'ngx-mask'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HeaderComponent } from './views/components/template/nav/header/header.component';
import { ClienteCreateComponent } from './views/components/cliente/cliente-create/cliente-create.component';
import { LoginComponent } from './views/components/login/login.component';
import { FuncionarioCreateComponent } from './views/components/funcionario/funcionario-create/funcionario-create.component';
import { HomeComponent } from './views/components/home/home.component';
import { FuncionarioReadComponent } from './views/components/funcionario/funcionario-read/funcionario-read.component';
import { FuncionarioUpdateComponent } from './views/components/funcionario/funcionario-update/funcionario-update.component';
import { CargoCreateComponent } from './views/components/funcionario/cargo/cargo-create/cargo-create.component';
import { CargoUpdateComponent } from './views/components/funcionario/cargo/cargo-update/cargo-update.component';
import { ProdutoReadComponent } from './views/components/produto/produto-read/produto-read.component';
import { PetReadComponent } from './views/components/pet/pet-read/pet-read.component';
import { ServicoReadComponent } from './views/components/servico/servico-read/servico-read.component';
import { ClienteReadComponent } from './views/components/cliente/cliente-read/cliente-read.component';
import { PedidoReadComponent } from './views/components/pedido/pedido-read/pedido-read.component';
import { PetCreateComponent } from './views/components/pet/pet-create/pet-create.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    ClienteCreateComponent,
    FooterComponent,
    NavComponent,
    LoginComponent,
    FuncionarioCreateComponent,
    HomeComponent,
    FuncionarioReadComponent,
    FuncionarioUpdateComponent,
    CargoCreateComponent,
    CargoUpdateComponent,
    ProdutoReadComponent,
    PetReadComponent,
    ServicoReadComponent,
    ClienteReadComponent,
    PedidoReadComponent,
    PetCreateComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    FormsModule,
    MatToolbarModule,
    MatSidenavModule,
    MatIconModule,
    MatButtonModule,
    MatListModule,
    MatCardModule,
    MatTableModule,
    MatSelectModule,
    MatInputModule,
    MatDatepickerModule,
    MatPaginatorModule,
    MatSnackBarModule,
    ReactiveFormsModule, 
    MatMenuModule,
    HttpClientModule,
    NgxMaskModule.forRoot() 
  ],
  providers: [{ provide: DEFAULT_CURRENCY_CODE, useValue: 'BRL'}],
  bootstrap: [AppComponent]
})
export class AppModule { }
