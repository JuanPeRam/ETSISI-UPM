% representación gráfica de líneas de campo y superficies equipotenciales 

% datos
k=9*10^9; % constante de Coulomb

q1dipolo = 10*10^-9;
x0q1 = 0.5;
y0q1 = 0;

q2dipolo = 2*q1dipolo;
x0q2 = -0.5;
y0q2 = 0;

a=-1.0:0.2:2.0;
b=-1.0:0.1:1.0;
[x,y]=meshgrid(a,b);

r0q1 = abs(sqrt((x-x0q1).^2+(y-y0q1).^2));
r0q2 = abs(sqrt((x-x0q2).^2+(y-y0q2).^2));

fxq1 = k*(q1dipolo*(x-x0q1)./r0q1.^3);
fyq1 = k*(q1dipolo*(y-y0q1)./r0q1.^3);

fxq2 = k*(q2dipolo*(x-x0q2)./r0q2.^3);
fyq2 = k*(q2dipolo*(y-y0q2)./r0q2.^3);

%Entre dos puntos, su vector es: (x-x0, y-y0);
r0=r0q1 + r0q2; % módulo del vector posición
fx=fxq1 + fxq2; % componente x del campo eléctrico
fy=fyq1 + fyq2; % componente y del campo eléctrico

V= (k*q1dipolo./r0q1) + (k*q2dipolo./r0q2); %Valor del potencial


f1=figure;
quiver(x,y,fx,fy,2,'r'); % dibujo las líneas del campo vectorial
hold on
contour(x,y,V, 40); % Dibujo de las líneas equipotenciales
xlabel('x (m)')
ylabel('y (m)')
title('potencial y campo por Coulomb')
hold off

[ex, ey]=gradient(-V,0.2,0.1); % campo como gradiente del potencial
f2=figure;
quiver(x,y,ex,ey,1,'r') % dibujo las líneas del campo vectorial
hold on
contour(x,y,V,40); % Dibujo de las líneas equipotenciales
xlabel('x (m)')
ylabel('y (m)')
title('potencial y campo por gradiente')
hold off


