- `${console.log('')}
This is on a new line` >> suporta multiline e template. **Deve sempre ser usado na montagem de queries SQL para evitar escapamento e ocasionar um SQL injection**
- 'This uses a escape character on _I\'am_' 
- "This is also _'possible'_ without any problems"
- "string de exemplo"[3] >> retorna o quarto caractere da string. se nao existir, retorna undefined

# propriedades
- .length >> retorna inteiro

# booleanos
- .includes('substring') >> procura substring na ordem exata dada como parâmetro
- .startsWith('substring')
- .endsWith('substring')

# procura (retornam index ou -1 se não encontrar) 
- .indexOf('substring')
- .lastIndexOf('substring')

# retornam string
- .charAt(index) >> se nao existir, retorna ''
- .slice(start, end)
- .replace('substring', 'newStr')
- .replaceAll('substring', 'newStr')
- .toUpperCase()
- .toLowerCase()

# retornam array
- .split('separator', limit) >> limit é opcional
