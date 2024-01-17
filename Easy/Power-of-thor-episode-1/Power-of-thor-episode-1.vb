Module Player
    Sub Main ()
        
        Dim inputs as String()
        Dim lightX as Integer ' the X position of the light of power
        Dim lightY as Integer ' the Y position of the light of power
        Dim initialTX as Integer ' Thor's starting X position
        Dim initialTY as Integer ' Thor's starting Y position
        inputs = Console.ReadLine().Split(" ")
        lightX = inputs(0)
        lightY = inputs(1)
        initialTX = inputs(2)
        initialTY = inputs(3)

        ' game loop
        While True
            Dim remainingTurns as Integer
            remainingTurns = Console.ReadLine()

            If lightY > initialTY Then
                initialTY += 1
                Console.Write("S")
            ElseIf lightY < initialTY Then
                initialTY -= 1
                Console.Write("N")
            End If
            If lightX > initialTX Then
                initialTX += 1
                Console.Write("E")
            ElseIf lightX < initialTX Then
                initialTX -= 1
                Console.Write("W")
            End If
            Console.WriteLine()
        End While
    End Sub
End Module
