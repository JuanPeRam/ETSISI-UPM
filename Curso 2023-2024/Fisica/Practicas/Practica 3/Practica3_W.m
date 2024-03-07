% REGLA DE LOS TRAPECIOS
% integración numérica campo eléctrico para calcular ddp
% introducir datos
a=input('extremo inferior de integración:');
b=input('extremo superior de integración:');
n=input('número de intervalos:');

% Definimos el vector x:
x = linspace(a,b,n+1);
% Definimos el campo eléctrico creado por un anillo
% de carga con kQ=60Nm^2/C y R=1m según ecuación (1)
fuerza = @(x) 3*(x.*exp(-0.8*x)+0.2);
y = fuerza(x);
trabajo = trapz(x,y);

fig = figure; fig.Color = "w";
grid on % la cuadrícula
plot(linspace(a,b,n),fuerza(linspace(a,b,n)),"r","linewidth",2); % el trabajo
hold on
xlabel('x') % etiquetamos el eje X
ylabel('W') % etiquetamos el eje Y
title("Trabajo por trapecios"); % ponemos título
% Dibujamos los trapecios de integración y rellenamos el área uno a uno
 for i = 1:numel(x)-1
area(x(i:i+1),y(i:i+1),"FaceColor","b","FaceAlpha",0.15)
% la función de matlab ‘area’ rellena áreas bajo curvas
 end
hold off

% Ponemos la leyenda
s1 = sprintf("$area$, n = %d",n);
legend("$fuerza$",s1,"FontSize",11,"Interpreter","latex")
% Mostramos el valor numérico (aproximado) de la integral (la ddp entra a y b)
xt=(a+b)/2; yt=(fuerza(b)+fuerza(a))/2;
% definimos las coordenadas x e y dónde aparecerá el texto
text(xt,yt, "$W_{aprox}\approx$ " + num2str(trabajo,5)+"$ V $", "Interpreter","Latex","FontSize",14) %num2str convierte números en array de caracteres