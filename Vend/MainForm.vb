Imports System.Globalization

Public Class MainForm

    Dim total As Double

    Private Sub MainForm_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        total = 0
        refreshView()
        PictureBox4.Visible = False
    End Sub

    Private Sub PictureBox1_Click(sender As Object, e As EventArgs) Handles PictureBox1.Click
        total = total + 0.25
        refreshView()
    End Sub

    Private Sub PictureBox2_Click(sender As Object, e As EventArgs) Handles PictureBox2.Click
        total = total + 0.1
        refreshView()
    End Sub

    Private Sub PictureBox3_Click(sender As Object, e As EventArgs) Handles PictureBox3.Click
        total = total + 0.05
        refreshView()
    End Sub

    Private Sub refreshView()
        Label2.Text = total.ToString("C", CultureInfo.CurrentCulture)
    End Sub

    Private Sub Button1_Click(sender As Object, e As EventArgs) Handles Button1.Click
        If (total >= 0.3) Then
            PictureBox4.Visible = True
        End If
    End Sub
End Class
