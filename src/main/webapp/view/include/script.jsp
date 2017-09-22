
<script src="visu/js/classie.js"></script>
<script>
		var menuLeft = document.getElementById( 'cbp-spmenu-s1' ),
			showLeftPush = document.getElementById( 'showLeftPush' ),
			body = document.body;
			
		showLeftPush.onclick = function() {
			classie.toggle( this, 'active' );
			classie.toggle( body, 'cbp-spmenu-push-toright' );
			classie.toggle( menuLeft, 'cbp-spmenu-open' );
			disableOther( 'showLeftPush' );
		};
		

		function disableOther( button ) {
			if( button !== 'showLeftPush' ) {
				classie.toggle( showLeftPush, 'disabled' );
			}
		}
	</script>

<!-- formate -->
<script>
            function SomenteNumero(e) {
                var tecla = (window.event) ? event.keyCode : e.which;
                if ((tecla > 47 && tecla < 58))
                        return true;
                else {
                    if (tecla === 8 || tecla === 0)
                            return true;
                    else
                        return false;
                }
            }
        </script>

<script>
            function formatar(mascara, documento) {
                    var i = documento.value.length;
                    var saida = mascara.substring(0, 1);
                    var texto = mascara.substring(i)

                    if (texto.substring(0, 1) !== saida) {
                            documento.value += texto.substring(0, 1);
                    }

            }
        </script>




<!-- formate -->

<!--scrolling js-->
<script src="visu/js/jquery.nicescroll.js"></script>
<script src="visu/js/scripts.js"></script>
<!--//scrolling js-->
<!-- Bootstrap Core JavaScript -->
<script src="visu/js/bootstrap.js"> </script>
