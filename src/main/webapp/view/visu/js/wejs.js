/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


        <script>
            function selecionaTudo(){
                var selecionados = document.getElementById('selectmultipleCad');
                for(i=0; i<selecionados.length;i++) {
                    selecionados.options[i].selected = true;
                }
                document.getElementById('lista').value = selecionados;
            }
        </script>

        <script>
            function mostraResposta(resposta){
                var remove = document.getElementById('selectmultipleDisp');
                remove.removeChild(remove.options);
                
                $('selectmultiple').value.resposta.responseText;
                
            }
        </script>
        
        <script>
            function inclui(){
                var novoElemento = document.createElement('option');
                var remove = document.getElementById('selectmultipleDisp');
                var itemSelecionado = remove.options[remove.selectedIndex].text;
                novoElemento.textContent = itemSelecionado;
                var lista = document.getElementById('selectmultipleCad');
                lista.appendChild(novoElemento);
                remove.removeChild(remove.options[remove.selectedIndex]);
            }
        </script>
        
        <script>
            function remove(){
                var novoElemento = document.createElement('option');
                var remove = document.getElementById('selectmultipleCad');
                var itemSelecionado = remove.options[remove.selectedIndex].text;
                novoElemento.textContent = itemSelecionado;
                remove.removeChild(remove.options[remove.selectedIndex]);
                var lista = document.getElementById('selectmultipleDisp');
                lista.appendChild(novoElemento);
            }
        </script>
        
        
       <script>
                function mostra(){
                    var x = document.getElementById('selectmultiple');
                    var itemSelecionado = x.options[x.selectedIndex].value;
                    document.getElementById('selecionado').value = itemSelecionado;
                    document.location.href = 'pesquisaModulos?busca='+document.getElementById('selecionado').value+'';
                }
        </script>