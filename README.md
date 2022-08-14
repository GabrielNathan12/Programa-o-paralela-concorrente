# Programa-o-paralela-concorrente

Especificação do problema 
Um bar resolveu liberar um número específico de rodadas grátis para seus n clientes presentes 
no estabelecimento. Esse bar possui x garçons. Cada garçom consegue atender a um número limitado (C) de 
clientes por vez. Como essas rodadas são liberadas, cada garçom somente vai para a copa para buscar o pedido 
quando todos os C clientes que ele pode atender tiverem feito o pedido ou não houver mais clientes a serem atendidos.
Após ter seu pedido atendido, um cliente pode fazer um novo pedido
após consumir sua bebida (o que leva um tempo aleatório) e a definição de uma nova rodada liberada. 
Uma nova rodada somente pode ocorrer quando foram atendidos todos os clientes que fizeram pedidos. Por definição, nem todos os clientes precisam pedir uma bebida a cada rodada.
Construção da solução 
Implemente uma solução que permita a passagem por parâmetro de:
 (i) número de clientes presentes no estabelecimento,
 (ii) número de garçons que estão trabalhando, 
(iii) capacidade de atendimento dos garçons e 
(iv) o número de rodadas que serão liberadas no bar. 
Cada garçom e cada cliente devem ser representados por threads, estruturalmente definidos como os pseudo-códigos que seguem:
thread cliente { 
    while (!fechouBar){ 
        fazPedido(); 
        esperaPedido(); 
        recebePedido(); 
        consomePedido();//tempo variável
    }
}
thread garçom{ 
    while (existemClientesNoBar){ 
        recebeMaximoPedidos(); 
        registraPedidos(); 
        entregaPedidos(); 
        rodada++; //serve como parâmetro para  fechar o bar
    } 
} 
Usar semáforos para controlar a concorrência e a sincronização entre as threads.  A ordem de chegada dos pedidos dos clientes na fila de pedidos de cada garçom deve ser respeitada. 
A solução não deve permitir que clientes furem essa fila. O garçom só pode ir para a copa quando tiver recebido seus C pedidos.  
O programa deve mostrar a evolução, portanto planeje bem o que será apresentado. Deve ficar claro o que está acontecendo 
no bar a cada rodada. Os pedidos dos clientes, os atendimentos pelos garçons, os deslocamentos para o pedido, a garantia de ordem de atendimento, etc. 

