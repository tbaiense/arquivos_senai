## Repos Remotos
- `git remote show` >> mostra repos
- `git remote add <nome_repo> <url_repo>` >> adiciona novo repositório remoto
- `git remote -v` >> repos remotos e seus urls
- `git remote --set-url <repo> <url>` >> mudar url de determinado repo
- `git remote rename <antigo_nome> <novo_nome>` >> renomeia repo
## Branches
- `git branch` >> mostra as branches LOCAIS
- `git branch -r` >> mostra as branches REMOTAS
- `git branch --no-merge` >> branches com merge pendente
- `git branch --merged` >> branches completamente mergidas
- `git branch -d <branch> [<branch2>]` >> deleta uma branch MERGIDA
- `git branch -D <branch> [<branch2>]` >> deleta uma branch NAO MERGIDA
- `git branch --move <nome_antigo> <nome_novo>` >> renomeia uma branch
- `git branch -v` >> exibe último commit de cada branch
- `git branch -vv` >> exibe último commit de cada branch e o repositório de TRACK
- `git branch -u <repo>/<branch> <branch>` >> define a quem cada branch vai fazer tracking
	`remote_branch`: branch remota no formato `<repo>`/`<branch>`, ex: origin/stable
- `git branch <nome> <commit>` >> cria nova branch com HEAD apontando para o commit especificado
- `git checkout -b <nova_branch> <repo>/<branch>` >> cria um nova branch baseada na remota e define tracking para ela
- `git push <remote> <new_branch_name>:<new_branch_name>` >> cria nova branch no repositório remoto
- `git push <remote> :<remote_branch>` >> apaga repositório remoto
- `git push -u <remote> <local_branch>:<remote_branch>` >> da push no remote e define o tracking para `local_branch` para `<remote_branch>`
## Merge e Rebase
- `git merge <branch_merge_into>` >> merge branch atual com conteúdos da especificada
- `git rebase <branch_rebase_into>` >> faz rebase na branch atual com a especificada
- `git rebase -i <parent_commit>` >> faz rebase interativo até o commit anterior ao especificado