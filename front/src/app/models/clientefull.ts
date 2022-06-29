import { Cliente } from './cliente';
import { UserAll } from './usuario/userAll';
export interface ClienteFull {
    userAll:  UserAll;
    cliente: Cliente;
}