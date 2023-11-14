.data
vector: .byte 5,2,3,4,1,1,2,3
MAX: .byte 0
MIN: .byte 2

.org 0x200
; Dirección de comienzo del código
.text
 .org 0x0
MAIN: daddi r1,r0,8 ; i = 8
DOWHILE: lbu r10,MIN(r0) ; { r10 = MIN
lbu r11,MAX(r0) ; r11 = MAX
daddi r1,r1,-1 ; i = i - 1
lb r2,vector(r1) ; r2 = vector[i]
slt r5,r2,r10 ; if (vector[i] < MIN)
beqz r5,ES_MAYOR ; …………………………
sb r2,MIN(r0) ; MIN = vector[i]
ES_MAYOR: slt r5,r11,r2 ; if (vector[i] > MAX)
beqz r5,CONT ; …………………………
sb r2,MAX(r0) ; MAX = vector[i]
CONT: bnez r1,DOWHILE ; } do while (i > 0)
halt