%leemos los datos de la tabla
T =tabulatedData;
% dibujamos los datos
plot(T.x,T.y,"ko")
xlabel("x")
ylabel("y")
grid on
hold on
set(gca,"XAxisLocation","origin","XTick",0:0.25:3)
% identificamos nuestros datos x,y
x = T.x;
y = T.y;
% cálculo de la integral I (la ddp)
I = 0; % inicializamos una variable
n = numel(x); % número de puntos del dataset
for i = 1:(n-1)
 I = I +(x(i+1) - x(i))*0.5*(y(i) + y(i+1));

area(x(i:i+1),y(i:i+1),"FaceColor","y","FaceAlpha",0.34)
end
hold off
% Mostrar el resultado
text(x(end)-2,2,"$ddp_{ab}\approx$ " + num2str(I,4)+"$ V$","Interpreter","Latex","FontSize",14)
fprintf("ddp = %2.5f",I)