USE [master]
GO
/****** Object:  Database [Sale_Computer_User]    Script Date: 06/02/2021 13:03:02 ******/
CREATE DATABASE [Sale_Computer_User] ON  PRIMARY 
( NAME = N'Sale_Computer_User', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL10_50.SQLEXPRESS\MSSQL\DATA\Sale_Computer_User.mdf' , SIZE = 2048KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'Sale_Computer_User_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL10_50.SQLEXPRESS\MSSQL\DATA\Sale_Computer_User_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [Sale_Computer_User] SET COMPATIBILITY_LEVEL = 100
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Sale_Computer_User].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Sale_Computer_User] SET ANSI_NULL_DEFAULT OFF
GO
ALTER DATABASE [Sale_Computer_User] SET ANSI_NULLS OFF
GO
ALTER DATABASE [Sale_Computer_User] SET ANSI_PADDING OFF
GO
ALTER DATABASE [Sale_Computer_User] SET ANSI_WARNINGS OFF
GO
ALTER DATABASE [Sale_Computer_User] SET ARITHABORT OFF
GO
ALTER DATABASE [Sale_Computer_User] SET AUTO_CLOSE OFF
GO
ALTER DATABASE [Sale_Computer_User] SET AUTO_CREATE_STATISTICS ON
GO
ALTER DATABASE [Sale_Computer_User] SET AUTO_SHRINK OFF
GO
ALTER DATABASE [Sale_Computer_User] SET AUTO_UPDATE_STATISTICS ON
GO
ALTER DATABASE [Sale_Computer_User] SET CURSOR_CLOSE_ON_COMMIT OFF
GO
ALTER DATABASE [Sale_Computer_User] SET CURSOR_DEFAULT  GLOBAL
GO
ALTER DATABASE [Sale_Computer_User] SET CONCAT_NULL_YIELDS_NULL OFF
GO
ALTER DATABASE [Sale_Computer_User] SET NUMERIC_ROUNDABORT OFF
GO
ALTER DATABASE [Sale_Computer_User] SET QUOTED_IDENTIFIER OFF
GO
ALTER DATABASE [Sale_Computer_User] SET RECURSIVE_TRIGGERS OFF
GO
ALTER DATABASE [Sale_Computer_User] SET  DISABLE_BROKER
GO
ALTER DATABASE [Sale_Computer_User] SET AUTO_UPDATE_STATISTICS_ASYNC OFF
GO
ALTER DATABASE [Sale_Computer_User] SET DATE_CORRELATION_OPTIMIZATION OFF
GO
ALTER DATABASE [Sale_Computer_User] SET TRUSTWORTHY OFF
GO
ALTER DATABASE [Sale_Computer_User] SET ALLOW_SNAPSHOT_ISOLATION OFF
GO
ALTER DATABASE [Sale_Computer_User] SET PARAMETERIZATION SIMPLE
GO
ALTER DATABASE [Sale_Computer_User] SET READ_COMMITTED_SNAPSHOT OFF
GO
ALTER DATABASE [Sale_Computer_User] SET HONOR_BROKER_PRIORITY OFF
GO
ALTER DATABASE [Sale_Computer_User] SET  READ_WRITE
GO
ALTER DATABASE [Sale_Computer_User] SET RECOVERY SIMPLE
GO
ALTER DATABASE [Sale_Computer_User] SET  MULTI_USER
GO
ALTER DATABASE [Sale_Computer_User] SET PAGE_VERIFY CHECKSUM
GO
ALTER DATABASE [Sale_Computer_User] SET DB_CHAINING OFF
GO
USE [Sale_Computer_User]
GO
/****** Object:  Table [dbo].[users]    Script Date: 06/02/2021 13:03:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[users](
	[username] [varchar](50) NOT NULL,
	[password] [varchar](50) NULL,
	[enabled] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[users] ([username], [password], [enabled]) VALUES (N'hao@gmail.com', N'{noop}123', 1)
INSERT [dbo].[users] ([username], [password], [enabled]) VALUES (N'hao2@gmail.com', N'{noop}123', 1)
INSERT [dbo].[users] ([username], [password], [enabled]) VALUES (N'hhh@gmail.com', N'{noop}123', 1)
INSERT [dbo].[users] ([username], [password], [enabled]) VALUES (N'khachhang@gmail.com', N'{noop}123', 1)
INSERT [dbo].[users] ([username], [password], [enabled]) VALUES (N'nhanvien@gmail.com', N'{noop}123', 1)
INSERT [dbo].[users] ([username], [password], [enabled]) VALUES (N'x@gmail.com', N'{noop}123', 1)
INSERT [dbo].[users] ([username], [password], [enabled]) VALUES (N'xxx@gmail.com', N'{noop}123', 1)
INSERT [dbo].[users] ([username], [password], [enabled]) VALUES (N'xyz@gmail.com', N'{noop}123', 1)
/****** Object:  Table [dbo].[authorities]    Script Date: 06/02/2021 13:03:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[authorities](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[username] [varchar](50) NULL,
	[authority] [varchar](50) NULL,
 CONSTRAINT [PK_authorities] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[authorities] ON
INSERT [dbo].[authorities] ([id], [username], [authority]) VALUES (1, N'xyz@gmail.com', N'ROLE_EMPLOYEE')
INSERT [dbo].[authorities] ([id], [username], [authority]) VALUES (2, N'nhanvien@gmail.com', N'ROLE_EMPLOYEE')
INSERT [dbo].[authorities] ([id], [username], [authority]) VALUES (3, N'hao@gmail.com', N'ROLE_CUSTOMER')
INSERT [dbo].[authorities] ([id], [username], [authority]) VALUES (4, N'hao2@gmail.com', N'ROLE_CUSTOMER')
INSERT [dbo].[authorities] ([id], [username], [authority]) VALUES (5, N'hhh@gmail.com', N'ROLE_CUSTOMER')
INSERT [dbo].[authorities] ([id], [username], [authority]) VALUES (6, N'x@gmail.com', N'ROLE_CUSTOMER')
INSERT [dbo].[authorities] ([id], [username], [authority]) VALUES (7, N'xxx@gmail.com', N'ROLE_CUSTOMER')
INSERT [dbo].[authorities] ([id], [username], [authority]) VALUES (8, N'khachhang@gmail.com', N'ROLE_CUSTOMER')
SET IDENTITY_INSERT [dbo].[authorities] OFF
/****** Object:  ForeignKey [FK__authoriti__usern__47DBAE45]    Script Date: 06/02/2021 13:03:02 ******/
ALTER TABLE [dbo].[authorities]  WITH CHECK ADD  CONSTRAINT [FK__authoriti__usern__47DBAE45] FOREIGN KEY([username])
REFERENCES [dbo].[users] ([username])
GO
ALTER TABLE [dbo].[authorities] CHECK CONSTRAINT [FK__authoriti__usern__47DBAE45]
GO
