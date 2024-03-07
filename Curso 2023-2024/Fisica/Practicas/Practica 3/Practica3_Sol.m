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
campo = @(x) (60)./(x.^2);
% potencial (valor exacto según ecuación (2)):
potencial = @(x) 60./(x);
%diferencia de potencial exacta
ddp_exacta=potencial(b)-potencial(a);
ddp_exacta
% función que vamos a integrar
y = campo(x);
% Realizamos la integración por trapecios

ddp_aprox =-trapz(x,y); % trapz es una función de matlab
%que calcula por el método de trapecios el área bajo la
%curva y=campo(x)
%el signo menos se debe a que, por definición, 𝑉𝑉(𝑏𝑏) − 𝑉𝑉(𝑎𝑎) = − ∫ 𝐸𝐸�⃗. 𝑑𝑑𝑙𝑙⃗ 𝑏𝑏𝑎𝑎 .
% Dibujamos el área bajo la curva
ddp_aprox
fig = figure; fig.Color = "w";
grid on % la cuadrícula
plot(linspace(a,b,n),campo(linspace(a,b,n)),"r","linewidth",2); % la función campo eléctrico
hold on
plot(linspace(a,b,n),potencial(linspace(a,b,n)),"g","linewidth",2); % el potencial (exacto)
hold on
xlabel('x') % etiquetamos el eje X
ylabel('E, V') % etiquetamos el eje Y
title("Integración por trapecios"); % ponemos título
% Dibujamos los trapecios de integración y rellenamos el área uno a uno
 for i = 1:numel(x)-1
area(x(i:i+1),y(i:i+1),"FaceColor","b","FaceAlpha",0.15)
% la función de matlab ‘area’ rellena áreas bajo curvas
 end
hold off
% Ponemos la leyenda
s1 = sprintf("$area$, n = %d",n);
legend("$campo$","$potencial$",s1,"FontSize",11,"Interpreter","latex")
% Mostramos el valor numérico (aproximado) de la integral (la ddp entra a y b)
xt=(a+b)/2; yt=(potencial(b)+potencial(a))/2;
% definimos las coordenadas x e y dónde aparecerá el texto
text(xt,yt, "$ddp_{aprox}\approx$ " + num2str(ddp_aprox,5)+"$ V $", "Interpreter","Latex","FontSize",14) %num2str convierte números en array de caracteres