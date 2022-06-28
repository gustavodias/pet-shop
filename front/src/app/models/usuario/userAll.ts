import { Bairro } from "../endereco/bairro";
import { Cidade } from "../endereco/cidade";
import { Estado } from "../endereco/estado";
import { Usuario } from './usuario';

export interface UserAll{
    estado: Estado;
    cidade: Cidade;
    bairro: Bairro;
    usuario: Usuario;
}