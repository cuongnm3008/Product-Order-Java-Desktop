USE [master]
GO
/****** Object:  Database [ProductOrder]    Script Date: 8/12/2021 6:07:18 PM ******/
CREATE DATABASE [ProductOrder]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'ProductOrder', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\ProductOrder.mdf' , SIZE = 3264KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'ProductOrder_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\ProductOrder_log.ldf' , SIZE = 816KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [ProductOrder] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [ProductOrder].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [ProductOrder] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [ProductOrder] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [ProductOrder] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [ProductOrder] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [ProductOrder] SET ARITHABORT OFF 
GO
ALTER DATABASE [ProductOrder] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [ProductOrder] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [ProductOrder] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [ProductOrder] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [ProductOrder] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [ProductOrder] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [ProductOrder] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [ProductOrder] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [ProductOrder] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [ProductOrder] SET  ENABLE_BROKER 
GO
ALTER DATABASE [ProductOrder] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [ProductOrder] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [ProductOrder] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [ProductOrder] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [ProductOrder] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [ProductOrder] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [ProductOrder] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [ProductOrder] SET RECOVERY FULL 
GO
ALTER DATABASE [ProductOrder] SET  MULTI_USER 
GO
ALTER DATABASE [ProductOrder] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [ProductOrder] SET DB_CHAINING OFF 
GO
ALTER DATABASE [ProductOrder] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [ProductOrder] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [ProductOrder] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'ProductOrder', N'ON'
GO
USE [ProductOrder]
GO
/****** Object:  Table [dbo].[tblCustomer]    Script Date: 8/12/2021 6:07:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tblCustomer](
	[CustomerID] [varchar](10) NOT NULL,
	[CustomerName] [nvarchar](50) NOT NULL,
	[Gender] [bit] NOT NULL,
	[Address] [nvarchar](50) NULL,
	[Birthdate] [datetime] NULL,
 CONSTRAINT [PK_tblCustomer] PRIMARY KEY CLUSTERED 
(
	[CustomerID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tblOrder]    Script Date: 8/12/2021 6:07:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tblOrder](
	[OrderID] [numeric](18, 0) NOT NULL,
	[CustomerID] [varchar](10) NOT NULL,
	[OrderDate] [datetime] NOT NULL,
 CONSTRAINT [PK_tblOrder] PRIMARY KEY CLUSTERED 
(
	[OrderID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tblOrderItem]    Script Date: 8/12/2021 6:07:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tblOrderItem](
	[OrderItemID] [numeric](18, 0) NOT NULL,
	[OrderID] [numeric](18, 0) NOT NULL,
	[ProductID] [varchar](10) NOT NULL,
	[Quantity] [int] NOT NULL,
 CONSTRAINT [PK_tblOrderItem] PRIMARY KEY CLUSTERED 
(
	[OrderItemID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tblProduct]    Script Date: 8/12/2021 6:07:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tblProduct](
	[ProductID] [varchar](10) NOT NULL,
	[ProductName] [nvarchar](50) NOT NULL,
	[Unit] [varchar](50) NOT NULL,
	[Price] [real] NULL,
	[Image] [varchar](50) NULL,
 CONSTRAINT [PK_tblProduct] PRIMARY KEY CLUSTERED 
(
	[ProductID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tblUser]    Script Date: 8/12/2021 6:07:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblUser](
	[account] [nchar](10) NOT NULL,
	[pass] [nchar](10) NULL,
	[name] [nvarchar](50) NULL,
	[gender] [bit] NULL,
	[address] [nvarchar](50) NULL,
	[dateofbirth] [date] NULL,
	[count] [int] NULL,
	[accountLogin] [int] NULL,
	[captcha] [int] NULL,
 CONSTRAINT [PK_tblUser] PRIMARY KEY CLUSTERED 
(
	[account] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
INSERT [dbo].[tblCustomer] ([CustomerID], [CustomerName], [Gender], [Address], [Birthdate]) VALUES (N'HA1', N'Nguyen Van An', 1, N'Ha Noi', CAST(N'1996-03-02 00:00:00.000' AS DateTime))
INSERT [dbo].[tblCustomer] ([CustomerID], [CustomerName], [Gender], [Address], [Birthdate]) VALUES (N'HE140375', N'Nguyen Manh Cuong', 1, N'Bac Ninh', CAST(N'2000-08-02 00:00:00.000' AS DateTime))
INSERT [dbo].[tblCustomer] ([CustomerID], [CustomerName], [Gender], [Address], [Birthdate]) VALUES (N'LP', N'Nguyen Hoang Phuc', 1, N'Ha Noi', CAST(N'2008-06-16 00:00:00.000' AS DateTime))
INSERT [dbo].[tblCustomer] ([CustomerID], [CustomerName], [Gender], [Address], [Birthdate]) VALUES (N'SA2', N'Nguyen Thi Huyen', 0, N'Bac Ninh', CAST(N'2000-02-03 00:00:00.000' AS DateTime))
INSERT [dbo].[tblProduct] ([ProductID], [ProductName], [Unit], [Price], [Image]) VALUES (N'CAM', N'Cam Ruot khong Do', N'do', 125, NULL)
INSERT [dbo].[tblProduct] ([ProductID], [ProductName], [Unit], [Price], [Image]) VALUES (N'Envy', N'Tao Envy', N'yen', 149, NULL)
INSERT [dbo].[tblProduct] ([ProductID], [ProductName], [Unit], [Price], [Image]) VALUES (N'HG', N'Hong Gion', N'bang anh', 229, NULL)
INSERT [dbo].[tblProduct] ([ProductID], [ProductName], [Unit], [Price], [Image]) VALUES (N'KW', N'Kiwi xanh', N'do', 125, NULL)
INSERT [dbo].[tblProduct] ([ProductID], [ProductName], [Unit], [Price], [Image]) VALUES (N'test4', N'Cam ngot', N'vnd', 1234, NULL)
INSERT [dbo].[tblUser] ([account], [pass], [name], [gender], [address], [dateofbirth], [count], [accountLogin], [captcha]) VALUES (N'cuongnm   ', N'cuong@1   ', N'Nguyen Manh Cuong', 1, N'Bac Ninh', CAST(N'2000-12-01' AS Date), 0, 0, 1)
INSERT [dbo].[tblUser] ([account], [pass], [name], [gender], [address], [dateofbirth], [count], [accountLogin], [captcha]) VALUES (N'cuongnm1  ', N'cuongnm1  ', N'Nguyen Manh Cuong', NULL, N'Bac Ninh', NULL, 0, 0, 1)
INSERT [dbo].[tblUser] ([account], [pass], [name], [gender], [address], [dateofbirth], [count], [accountLogin], [captcha]) VALUES (N'hungnd    ', N'hung@4    ', N'Nguyen Duc Hung', 1, N'Hai Duong', CAST(N'2020-12-12' AS Date), 0, 0, 1)
INSERT [dbo].[tblUser] ([account], [pass], [name], [gender], [address], [dateofbirth], [count], [accountLogin], [captcha]) VALUES (N'kiennn    ', N'kien@3    ', N'Nguyen Ngoc Kien', 1, N'Hung Yen', CAST(N'2014-11-05' AS Date), 0, 0, 1)
INSERT [dbo].[tblUser] ([account], [pass], [name], [gender], [address], [dateofbirth], [count], [accountLogin], [captcha]) VALUES (N'linhnh    ', N'linh@6    ', N'Nguyen Hai Linh', 0, N'Quang Ninh', CAST(N'2008-08-09' AS Date), 0, 0, 1)
INSERT [dbo].[tblUser] ([account], [pass], [name], [gender], [address], [dateofbirth], [count], [accountLogin], [captcha]) VALUES (N'phuongnh  ', N'phuong@2  ', N'Nguyen Hai Phuong', 1, N'Bac Ninh', CAST(N'1990-03-12' AS Date), 0, 0, 1)
INSERT [dbo].[tblUser] ([account], [pass], [name], [gender], [address], [dateofbirth], [count], [accountLogin], [captcha]) VALUES (N'quangnd   ', N'quang@5   ', N'Nguyen Dinh Quang', 1, N'Ha Noi', CAST(N'1995-01-23' AS Date), 0, 0, 1)
INSERT [dbo].[tblUser] ([account], [pass], [name], [gender], [address], [dateofbirth], [count], [accountLogin], [captcha]) VALUES (N'traNT     ', N'thanhtra  ', N'Nguyen Thanh Tra', 0, N'Thai Nguyen', CAST(N'1998-09-06' AS Date), 0, 0, 1)
USE [master]
GO
ALTER DATABASE [ProductOrder] SET  READ_WRITE 
GO
