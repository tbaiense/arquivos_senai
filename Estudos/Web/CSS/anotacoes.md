# pseudo-classes
- p:focus
- p:hover
- a:visited
- :is(p, h1, h2) img >> seleciona img que estão aninhados dentro de p, h1 ou h2

# combinators
- p li >> descendant
- p > li >> direct children
- p + img >> adjascent sibling
- p ~ img >> general sibling

# pseudo-elementos 
- p::after {content: 'CONTEUDO_APOS'}
- p::before {content: 'CONTEUDO_ANTES'}