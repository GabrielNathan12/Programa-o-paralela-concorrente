# Programa-o-paralela-concorrente

Especificação do problema <br>
Um bar resolveu liberar um número específico de rodadas grátis para seus n clientes presentes <br>
no estabelecimento. Esse bar possui x garçons. Cada garçom consegue atender a um número limitado (C) de <br> 
clientes por vez. Como essas rodadas são liberadas, cada garçom somente vai para a copa para buscar o pedido <br> 
quando todos os C clientes que ele pode atender tiverem feito o pedido ou não houver mais clientes a serem atendidos. <br>
Após ter seu pedido atendido, um cliente pode fazer um novo pedido <br>
após consumir sua bebida (o que leva um tempo aleatório) e a definição de uma nova rodada liberada. <br> 
Uma nova rodada somente pode ocorrer quando foram atendidos todos os clientes que fizeram pedidos. Por definição, nem todos os clientes precisam pedir uma bebida a cada rodada. <br>
Construção da solução <br>
Implemente uma solução que permita a passagem por parâmetro de:<br>
 (i) número de clientes presentes no estabelecimento,<br>
 (ii) número de garçons que estão trabalhando, <br>
(iii) capacidade de atendimento dos garçons e <br>
(iv) o número de rodadas que serão liberadas no bar.<br> 
Cada garçom e cada cliente devem ser representados por threads, estruturalmente definidos como os pseudo-códigos que seguem:<br>
thread cliente { <br>
    while (!fechouBar){ <br>
        fazPedido(); <br>
        esperaPedido(); <br>
        recebePedido(); <br>
        consomePedido();//tempo variável <br>
    }<br>
}<br>
thread garçom{ <br>
    while (existemClientesNoBar){<br> 
        recebeMaximoPedidos(); <br>
        registraPedidos(); <br>
        entregaPedidos(); <br>
        rodada++; //serve como parâmetro para  fechar o bar <br>
    } <br>
} <br>
Usar semáforos para controlar a concorrência e a sincronização entre as threads.  A ordem de chegada dos pedidos dos clientes na fila de pedidos de cada garçom deve ser respeitada.<br> 
A solução não deve permitir que clientes furem essa fila. O garçom só pode ir para a copa quando tiver recebido seus C pedidos. <br> 
O programa deve mostrar a evolução, portanto planeje bem o que será apresentado. Deve ficar claro o que está acontecendo <br>
no bar a cada rodada. Os pedidos dos clientes, os atendimentos pelos garçons, os deslocamentos para o pedido, a garantia de ordem de atendimento, etc. <br>

