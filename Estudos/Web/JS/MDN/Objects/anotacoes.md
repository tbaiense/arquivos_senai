# Objetos
- Object.getPrototypeOf() >> meio padrão de encontrar o protótipo de um objeto
- _this_ se refere ao objeto atual, mesmo dentro de um protótipo (pode ser usado dentro de protótipos para alterar propriedades do construtor)
- Object.assign(meuConstructorFunction.prototype, meuPrototipoOuSuperClasse) >> Atribui um ou mais protótipos ao protótipo do contructor (não-indempotent)
- São delegativas >> executam métodos nos protótipos e permitem mudar os protótipos at-runtime
- MERGINDO OBJETOS:
    1) const objMergido = {...objOriginal, ...objMergir} >> Vai fazer shallow copying, ou seja é possivel que uma alteração afete o original.
    ou
    2) const objMergido = JSON.parse(JSON.stringify({...objMergir, ...objOriginal})) >> cria um novo objeto usando os métodos JSON, que separa os valores originais
        **obs: as propriedades tem de ser serializáveis (não podem ser funções ou métodos) para que seja possível usar _JSON.stringify()_ e _JSON.parse()_**
## Classes
- Anexam as propriedades diretamente em suas instâncias e seus métodos dentro do protótipo de suas intâncias
Anexam as propriedades e métodos de super classes **dentro do próprio objeto**, ao invés de mantê-la no prototype.
    class MinhaClasse {
        prop1;
        prop2;
        #prop3;

        constructor(prop1, prop2, prop3) {
            this.prop1 = prop1;
            this.prop2 = prop2;
            this.#prop3 = prop3;
        }

        metodo1() {
            console.log(this.prop1);
        }

        #metodo2() {
            console.log(this.prop2);
        }

        metodo3() {
            metodo1();
            #metodo2();
            console.log(this.#prop3);
        }
    }

- Sub classes >> podem subtituir métodos da superclasse (polymorphisom)

    class Sub extends MinhaClasse {
        prop4;

        constructor(prop1, prop2, prop3, prop4) {
            super(prop1, prop2, prop3);
            this.prop4;
        }

        metodo4() {
            console.log(this.prop4);
        }
    }
