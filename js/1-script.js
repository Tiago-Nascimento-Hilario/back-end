/*Estrutura de classes*/
class Conta{
    _nome;
    _saldo = 0;
    _sacar(valor){
        if(this._saldo >= valor){
            this._saldo -= valor;
            return this._saldo
        }
    };

    _depositar(valor){
        this._saldo += valor;
        return this._saldo;
    }
}

const conta1 = new Conta();
const conta2 = new Conta();

conta1._nome = "João";
conta2._nome = "Alex";

console.log(conta1, conta2)

