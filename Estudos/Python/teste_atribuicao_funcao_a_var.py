def showError(s='Inválido'):
    """Função que printa mensagem de erro usando uma string como argumento"""
    msg = '\nERRO: '
    p = print(msg)
    match s:
        case 'arquivo':
            msg += 'Arquivo inválido.\n\n'
            p
        case _:
            msg += s
            p
showError('arquivo')
