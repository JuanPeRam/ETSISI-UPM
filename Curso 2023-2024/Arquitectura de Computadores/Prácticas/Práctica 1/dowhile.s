.data
    vectorA: .byte 1,2,3,4,5,6,7
    vectorB: .byte 1,2,3,1,2,3,1
    
    vectorSum: .space 7
.code
    MAIN: daddi r1,r0,8
    DOWHILE: daddi r1,r1,-1 
    lb r2,vectorA(r1) 
    lb r3,vectorB(r1) 
    dadd r4,r2,r3 
    sb r4,vectorSum(r1)
    bnez r1,DOWHILE
    halt