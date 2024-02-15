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

t1 = tc;
x1 = tc*v0;
x1
y1=a*(tc^2)/2; %componente y posición de salida en m
vx1=v0; % componente x de la velocidad de salida en m/s
vy1=a*tc;% componente y de la velocidad de salida en m/s
alfa=atan(vy1/vx1); %ángulo de salida en radianes
angulo=alfa*180/pi;

%segundo tramo
i = 0:2*n;
t = tc+dt*i;
x = x1+v0*dt*i;
y = y1+vy1*(dt*i)-a*((dt*i).^2) / 2;
vx = v0;
vy = vy1-a*(dt*i);

figure(f1);
plot(t,y,'b');
xlabel('t (s)');
ylabel('y (m)');
grid on
title('desplazamiento y(t)');
hold on;

figure(f2);
plot(t,x,'b');
xlabel('t (s)');
ylabel('x (m)');
grid on
title('desplazamiento x(t)');
hold on;

figure(f3);
plot(x,y,'b');
xlabel('y (m)');
ylabel('x (m)');
grid on
title('trayectoria y(x)');
hold on;

figure(f4);
plot(t,vy,'b');
xlabel('t (s)');
ylabel('v (m/s)');
grid on
title('velocidad v(t)');
hold on;

t2 = 3*tc; %t2 es la suma de t1 + 2* tc (el doble de tiempo que t1)
x2 = t2*v0;
y2=y1+vy1*2*tc-a*4*(tc^2)/2; %componente y posición de salida en m
vx2=v0; % componente x de la velocidad de salida en m/s
vy2=vy1-a*2*tc;% componente y de la velocidad de salida en m/s
alfa2=atan(vy2/vx2); %ángulo de salida en radianes
angulo2=alfa2*180/pi;

%tercer tramo
i = 0:2*n;
t = t2+dt*i;
x = x2+v0*dt*i;
y = y2+vy2*(dt*i)+a*((dt*i).^2) / 2;
vx = v0;
vy = vy2+a*(dt*i);

figure(f1);
plot(t,y,'g');
xlabel('t (s)');
ylabel('y (m)');
grid on
title('desplazamiento y(t)');
hold on;

figure(f2);
plot(t,x,'g');
xlabel('t (s)');
ylabel('x (m)');
grid on
title('desplazamiento x(t)');
hold on;

figure(f3);
plot(x,y,'g');
xlabel('y (m)');
ylabel('x (m)');
grid on
title('trayectoria y(x)');
hold on;

figure(f4);
plot(t,vy,'g');
xlabel('t (s)');
ylabel('v (m/s)');
grid on
title('velocidad v(t)');
hold on;

t3 = t2+(2*tc); %t2 es la suma de t1 + 2* tc (el doble de tiempo que t1)
x3 = t3*v0;
y3=y2+vy2*t3+a*(t3.^2)/2; %componente y posición de salida en m
vx3=v0; % componente x de la velocidad de salida en m/s
vy3=vy2+a*2*tc;% componente y de la velocidad de salida en m/s
alfa3=atan(vy3/vx3); %ángulo de salida en radianes
angulo3=alfa3*180/pi;

%cuarto tramo
i = 0:2*n;
t = t3+dt*i;
x = x3+v0*dt*i;
y = y3+vy3*(dt*i)-a*((dt*i).^2) / 2;
vx = v0;
vy = vy3-a*(dt*i);

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

t4 = t3+(2*tc); %t2 es la suma de t1 + 2* tc (el doble de tiempo que t1)
x4 = t4*v0;
y4=y3+vy3*2*tc+a*16*(tc^2)/2; %componente y posición de salida en m
vx4=v0; % componente x de la velocidad de salida en m/s
vy4=vy3+a*2*tc;% componente y de la velocidad de salida en m/s
alfa4=atan(vy4/vx4); %ángulo de salida en radianes
angulo4=alfa4*180/pi;