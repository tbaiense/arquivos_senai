"use strict";

//Objeto Livro
const LivroPrototype = {
  autores: '',
  titulo: '',
  ano: undefined,
  editora: '',
  edicao: undefined,
  idioma: '',
  categorias: '',
}

function Livro(obj=LivroPrototype) {
  this.autores = obj.autores;
  this.titulo = obj.titulo;
  this.ano = obj.ano;
  this.editora = obj.editora;
  this.edicao = obj.edicao;
  this.idioma = obj.idioma;
  this.categorias = obj.categorias;
}

Object.assign(Livro.prototype, LivroPrototype);

const EstanteLivrosPrototype = {
  identificacao: '',
  prateleiras: [],
};

const PrateleiraLivrosPrototype = {
  identificacao: '',
  livros: [],
};

function PrateleiraLivros(obj) {
  this.identificacao = obj.identificacao;
  this.livros = [];
  if (obj.livros instanceof Array) {
    obj.livros.forEach((livro) => {
      this.livros.push(livro);
    });
  }
}

Object.assign(PrateleiraLivros.prototype, PrateleiraLivrosPrototype);

function EstanteLivros(identificacao, arrayPrateleiras) {
  this.identificacao = identificacao;
  this.prateleiras = [];
  if (arrayPrateleiras instanceof Array) {
    arrayPrateleiras.forEach((prateleira) => {
      this.prateleiras.push(prateleira)
    });
  }
}

function gerarPrateleiras(letra) {
  const prateleiras = [];
  for (let p = 0; p < 6; p++) {
    const prateleira = new PrateleiraLivros({identificacao: `${letra}${p}`});
    // Cria 15 livros para cada prateleira
    for (let l = 0; l < 15; l++) {
      const livro = new Livro({
        autores: `Autor ${Math.floor(Math.random() * 100 + 1)}`,
        titulo: `Livro ${Math.floor(Math.random() * 1000 + 1)}`,
        ano: `${Math.floor(Math.random() * 124 + 1901)}`,
        edicao: `${Math.floor(Math.random() * 2 + 1)}`,
      });
      prateleira.livros.push(livro);
    }
    prateleiras.push(prateleira);
  }
  return prateleiras;
}
const estantes = [];
estantes.push(new EstanteLivros('minha Estante', gerarPrateleiras("A")));
estantes.push(new EstanteLivros('outra estante', gerarPrateleiras("B")));
estantes.push(new EstanteLivros('mais uma estante lá', gerarPrateleiras("C")));

const selEstante = document.getElementById('estante');
const selPrateleira = document.getElementById('prateleira');
const selLivro = document.getElementById('livro');
const btn = document.getElementById('procurar');
const outAutor = document.getElementById('autorLivro');
const outTitulo = document.getElementById('tituloLivro');
const outAno = document.getElementById('anoLivro');
const outEdicao = document.getElementById('edicaoLivro');

for (let estante = 0; estante < estantes.length; estante++) {
  const optEstante = document.createElement('option');
  optEstante.value = estante;
  optEstante.textContent = estantes[estante].identificacao;
  selEstante.appendChild(optEstante);
}

function atualizarPrateleiras(estante=0) {
  selPrateleira.innerHTML = '';
  for (let prateleira = 0; prateleira < estantes[estante].prateleiras.length; prateleira++) {
    const optPrateleira = document.createElement('option');
    optPrateleira.value = prateleira;
    optPrateleira.textContent = estantes[estante].prateleiras[prateleira].identificacao;
    selPrateleira.appendChild(optPrateleira);
  }

}
//atualizarPrateleiras(selEstante.value);

function atualizarLivros(estante=0,prateleira=0) {
  selLivro.innerHTML = '';
  for(let livro = 0; livro < estantes[estante].prateleiras[prateleira].livros.length; livro++) {
    const optGrpLivro = document.createElement('optgroup');
    optGrpLivro.label = estantes[estante].prateleiras[prateleira].livros[livro].autores;
    const optLivro = document.createElement('option');
    optLivro.value = livro;
    optLivro.textContent = estantes[estante].prateleiras[prateleira].livros[livro].titulo;
    optGrpLivro.appendChild(optLivro);
    selLivro.appendChild(optGrpLivro);
  }
}
//atualizarLivros(selEstante.value, selPrateleira.value);

selEstante.addEventListener('change', () => {
  atualizarPrateleiras(selEstante.value)
});
selPrateleira.addEventListener('change', () => {
  atualizarLivros(selEstante.value, selPrateleira.value)
});

function exibirLivro() {
  const livro = estantes[selEstante.value].prateleiras[selPrateleira.value].livros[selLivro.value];
  outAutor.textContent = livro.autores;
  outTitulo.textContent = livro.titulo;
  outAno.textContent = livro.ano;
  outEdicao.textContent = livro.edicao;
};

btn.addEventListener('click', () => {
  exibirLivro();
});