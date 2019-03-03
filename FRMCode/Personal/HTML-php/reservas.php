<html>
    <head>
        <meta charset="UTF-8">
        <title> Práctica</title>
        <link href="solucion.css" rel="stylesheet" type="text/css" />

    </head>
    <body>
        <h1>Reservas - Resultado</h1>
        <?php
        
        $cantidad = (isset($_REQUEST['hora'])) ? $_REQUEST['hora'] : "";
        $nome = (isset($_REQUEST['nome'])) ? $_REQUEST['nome'] : "";
        $origen = (isset($_REQUEST['origen'])) ? $_REQUEST['origen'] : "";
        $destino = (isset($_REQUEST['destino'])) ? $_REQUEST['destino'] : "";


        $cantidadOk = false;
        $nomeOk = false;
        $origenOk = false;
        $destinoOk = false;

        $maximo = 1000000;

        if ($cantidad == "") {
            print "<p class=\"error\">Non puxo hora.</p>\n";
        } else {
            $cantidadOk = true;
        }
        if ($nome == "") {
            print "<p class=\"error\">Non puxo a nome de quen está a reserva.</p>\n";
        } else {
            $nomeOk = true;
        }
       
        if ($origen != "luns" && $origen != "martes" && $origen != "mercores" && $origen != "xoves" && $origen != "venres") {
            print "  <p class=\"error\">Non introduceu o dia.</p>\n";
        } else {
            $origenOk = true;
        }

        if ($destino != "1" && $destino != "2" && $destino != "3" && $destino != "4" && $destino != "5") {
            print "  <p class=\"error\">Non introduceu as persoas.</p>\n";
        } else {
            $destinoOk = true;
        }

        if ($cantidadOk && $origenOk && $destinoOk && $nomeOk) {
            
            print "<p>Rexistrouse unha reserva para o " . $origen . ", ás " . $cantidad . ", para " . $destino." a nome de " . $nome . "</p>\n";
            print "<p>Gracias por utilizar este servicio.</p>\n";
        }

        print "<p><a href=\"reservas.html\">Volver al formulario.</a></p>\n";
        ?>
    </body>
</html>