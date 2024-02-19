% problema base de movimiento de partículas cargadas en campos eléctricos
% datos
v0=3.4*10^6; % velocidad inicial en x (m)
d=0.045; % distancia (m) en presencia de campo eléctrico
E=520; % campo eléctrico (N/C)
q=-1.61*10^(-19); % carga eléctrica del electrón (C)
m=9.11*10^(-31); % masa del electrón (kg)

a=q*E/m;%aceleración en la dirección del campo eléctrico
tc=d/v0; % tiempo total en presencia de campo eléctrico 

n=input('número de pasos, n: ');

%primer tramo
dt = tc/n;
i = 0:n;
t = dt*i;
x = v0*t;
y = a*((t.^2)) / 2;

vx = v0;
vy = a*t;

f1 = figure;
plot(t,y,'r');
xlabel('t (s)');
ylabel('y (m)');
grid on
title('desplazamiento y(t)');
hold on;

f2 = figure;
plot(t,x,'r');
xlabel('t (s)');
ylabel('x (m)');
grid on
title('desplazamiento x(t)');
hold on;

f3 = figure;
plot(x,y,'r');
xlabel('y (m)');
ylabel('x (m)');
grid on
title('trayectoria y(x)');
hold on;

f4 = figure;
plot(t,vy,'r');
xlabel('t (s)');
ylabel('v (m/s)');
grid on
title('velocidad v(t)');
hold on;

signo = -1;
yi = a*(tc.^2)/2;
xi = tc*v0;
vyi = a*tc;
vxi = v0;
ti = tc;

vueltas = 5;
for j = 1:vueltas

    i= 0:2*n;
    t = ti+dt*i;
    x = xi+v0*dt*i;
    y = yi+vyi*(dt*i)+signo*a*((dt*i).^2) / 2;
    vx = v0;
    vy = vyi+signo*a*(dt*i);

    figure(f1);
    plot(t,y,'p');
    xlabel('t (s)');
    ylabel('y (m)');
    grid on
    title('desplazamiento y(t)');
    hold on;
    
    figure(f2);
    plot(t,x,'p');
    xlabel('t (s)');
    ylabel('x (m)');
    grid on
    title('desplazamiento x(t)');
    hold on;
    
    figure(f3);
    plot(x,y,'p');
    xlabel('y (m)');
    ylabel('x (m)');
    grid on
    title('trayectoria y(x)');
    hold on;
    
    figure(f4);
    plot(t,vy,'p');
    xlabel('t (s)');
    ylabel('v (m/s)');
    grid on
    title('velocidad v(t)');
    hold on;
    
    
    ti = ti+2*tc; %t2 es la suma de t1 + 2* tc (el doble de tiempo que t1)
    xi = ti*v0;
    yi=yi+vyi*2*tc+signo*a*4*(tc.^2)/2; %componente y posición de salida en m
    vxi=v0; % componente x de la velocidad de salida en m/s
    vyi=vyi+signo*a*2*tc;% componente y de la velocidad de salida en m/s
    alfai=atan(vyi/vxi); %ángulo de salida en radianes
    anguloi=alfa2*180/pi;

    signo = -signo;
end
