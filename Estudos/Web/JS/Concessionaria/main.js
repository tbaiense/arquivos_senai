"use strict";

class Carro {
  fabricante;
  modelo;
  preco;
  categoria;
  quantidade;
  diasAluguel;
  id;
  static #carrosCadastrados = 4;
  constructor(infoObj) {
    const novoCarro = JSON.parse(JSON.stringify({...infoObj}));
    this.fabricante = novoCarro.fabricante;
    this.modelo = novoCarro.modelo;
    this.preco = novoCarro.preco;
    this.categoria = novoCarro.categoria;
    this.quantidade = (novoCarro.quantidade) ? novoCarro.quantidade : 1;
    this.diasAluguel = (novoCarro.diasAluguel) ? novoCarro.diasAluguel : undefined;
    this.id = `A${Carro.#carrosCadastrados++}`;
  }
}

const Concessionaria = {
  carros: {
    chevrolet: {
      A0: {
        fabricante: 'chevrolet',
        modelo: 'Onix',
        preco: 90000,
        categoria: 'popular',
        quantidade: 1,
        diasAluguel: undefined,
        id: 'A0',
      },
      A1: {
        fabricante: 'chevrolet',
        modelo: 'Cruze',
        preco: 180000,
        categoria: 'premium',
        quantidade: 10,
        diasAluguel: undefined,
        id: "A1",
      },
    },
    toyota: {
      A2: {
        fabricante: 'toyota',
        modelo: 'Corolla',
        preco: 180000,
        categoria: 'popular',
        quantidade: 1,
        diasAluguel: undefined,
        id: "A2",
      },
      A3: {
        fabricante: 'toyota',
        modelo: 'etios',
        preco: 100000,
        categoria: 'popular',
        quantidade: 1,
        diasAluguel: undefined,
        id: "A3",
      },
    },
  },
  vender(carro) {
    const marcas = this.carros;
    for (const marca in marcas) {
      for (const idCarro in marcas[`${marca}`]) {
        if (idCarro === carro) {
          if (marcas[`${marca}`][`${idCarro}`].quantidade > 1) {
            marcas[`${marca}`][`${idCarro}`].quantidade--;
          } else {
            delete marcas[`${marca}`][`${idCarro}`];
          }
        }
      }
    }
  },
};

//Templates
const rowTemplate = document.getElementById('row-template').cloneNode(true);
rowTemplate.removeAttribute('hidden');
rowTemplate.removeAttribute('id');
rowTemplate.querySelector('input[type="radio"]').removeAttribute('disabled');
const tabela = document.querySelector('tbody')
const btn = document.getElementById('btnComprar');

function popularTabelaCarros() {
  tabela.innerHTML = '';
  for(const marca in Concessionaria.carros) {
    const carros = Concessionaria.carros[`${marca}`];
    for (const idCarro in carros) {
      const carro = carros[`${idCarro}`]
      const newRow = rowTemplate.cloneNode(true);
      newRow.querySelector('input[type="radio"]').value = carro.id;
      const carCell = newRow.querySelector('.car-cell');
      const carInfo = Object.values(carro);
      carCell.textContent = carInfo.join(' ');
      tabela.appendChild(newRow);
    }
  }
}

btn.addEventListener('click', () => {
  for (const input of tabela.querySelectorAll('input[type="radio"]')) {
    if (input.checked) {
      Concessionaria.vender(input.value);
    }
  }
  popularTabelaCarros();
});

popularTabelaCarros();


