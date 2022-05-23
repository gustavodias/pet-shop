import { Cliente } from './cliente';
import { Endereco } from './endereco';
import { Contato } from './contato';
export interface CLienteFull {
    endereco:  Endereco;
    cliente: Cliente;
    contato: Contato;
}