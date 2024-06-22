[REF no MDN] (https://developer.mozilla.org/en-US/docs/Web/Events#event_index)

# Coisas que aprendi, mas não diretamente relacionadas ao conteúdo de eventos
- Element.getElementById()
- Element.querySelector()
- Element.querySelectorAll() >> Retorna um Nodelist dos encontrados (se nenhum, returno é 'null'), que pode ser iterada através de for..of
- Element.style. >> Acesso a estilização de qualquer Element

- Element.classList
- Element.classList.add()
- Element.classList.remove()
- Element.id
- Element.setAttribute('attrb', 'value')

- Element.innerHTML >> manipulação direta do conteúdo HTML de um Node, permitindo escrever HTML dentro de uma string e attribuir a um elemento
- Element.textContent

- Element.appendChild(Node, Node2, ...)
- Element.replaceChildren(Node)
- document.createElement('tagname') >> cria e retorna o Node de um novo elemento do tipo _tagname_
- document.activeElement >> Node em que o _agent_ está com foco ou ativo

- HTMLElement.click()
- HTMLElement.focus()
- HTMLElement.blur()

- HTMLFormElement.submit()

# EventTarget
## Métodos
- EventTarget.addEventListener('type', eventHandlerFunction (evt))
- EventTarget.removeEventListener('type', eventHandlerFunction (evt))

# Event
## Propriedades
- target
- currentTarget
- type

## Metodos
- Event.stopPropagation()
- Event.preventDefault()

# Objetos / interfaces de evento
São os objetos responsáveis por enviar os events para os event targets:
- MouseEvent
- PointerEvent
- SubmitEvent
- KeyboardEvent

## MouseEvent 
### Propriedades
- detail: número de cliques consecutivos

### event types
- dblclick
- mouseover | funcionam com elementos aninhados
- mouseout  |
- mouseenter | funcionam apenas com os parentes de elementos aninhados
- mouseleave |
- mousedown
- mouseup
- click

## FocusEvent event types
- focus
- blur