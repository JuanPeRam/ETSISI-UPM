.data
    vectorA: .word32 1,2,3,4,5,6,7
    vectorB: .word32 1,2,3,1,2,3,1
    
    vectorSum: .word32 1,1,1,1,1,1,1
.code
    MAIN: daddi r1,r0,28
    WHILE: beqz r1,FIN
    daddi r1,r1,-4 
    lw r2,vectorA(r1) 
    lw r3,vectorB(r1) 
    dadd r4,r2,r3 
    sw r4,vectorSum(r1)
    j WHILE
    FIN: halt