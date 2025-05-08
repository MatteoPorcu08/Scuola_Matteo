org 100h

 mov al,45d
 mov bl,5d
 div bl
 
 mov cl,al
 
 mov al,3d
 mov bl,3d
 mul bl
 
 mov al,cl
 add al,9
ret




