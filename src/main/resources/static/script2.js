var tabela = document.querySelector("#tabfornecedores");

tabela.addEventListener("click", function(event){
    var elementoClicado = event.target;
    if (elementoClicado.classList.contains("btn-excluir")) {
        var celula = elementoClicado.parentNode;
        var linha = celula.parentNode;
        linha.remove();
    }
   
})