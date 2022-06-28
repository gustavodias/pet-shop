import { Bairro } from './../endereco/bairro';
import { Estado } from '../endereco/estado';
import { Cidade } from '../endereco/cidade';
import { Funcionario } from './funcionario';
import { UserAll } from '../usuario/userAll';
import { Cargo } from './cargo';
export interface FuncionarioFull{
    userAll: UserAll;
    cargo: Cargo;
    funcionario: Funcionario;
}