org 100h

mov al,60d
sub al,10d

mov bl,al

mov al,20d
sub al,10d

mov al,bl
mov bl,10d
div bl

mov bl,50d
sub bl,40d 

mov cl,al
mov al,bl
mul cl

ret




